	@Transactional
	public void importData() throws IOException, SQLException {
		StreamSource source = new StreamSource(MapService.class.getResourceAsStream("/input/xml-input-hungary.xml"));

		XMLCounties xmlCounties = xmlCountiesDao.read(source);
		
		for (XMLCounty xmlCounty : xmlCounties.getCounties()) {
			CountyEntity county = createCounty(xmlCounty);
			
			List<PathCommandEntity> pathCommands = new LinkedList<>();
			
			xmlCounty.getPathCommands().forEach(xmlPathCommand -> {
				createPathCommand(pathCommands, xmlPathCommand);
			});
			
			county.setPathCommands(pathCommands);
			countyDao.save(county);
			}
	}
	
	private CountyEntity createCounty(XMLCounty xmlCounty) {
		CountyEntity county = new CountyEntity();
		
		county.setOrigId(xmlCounty.getId());
		county.setName(xmlCounty.getName());
		county.setSeat(xmlCounty.getSeat());
		county.setColor(xmlCounty.getColor());
		county.setPopulation(xmlCounty.getPopulation());
		county.setSize(xmlCounty.getSize());
		return county;
	}
	
	private void createPathCommand(List<PathCommandEntity> pathCommands, XMLPathCommand xmlPathCommand) {
		PathCommandEntity pathCommand = new PathCommandEntity();	 	
		pathCommand.setType(xmlPathCommand.getType());
		pathCommand.setPositionX(xmlPathCommand.getPositionX());
		pathCommand.setPositionY(xmlPathCommand.getPositionY());
		pathCommands.add(pathCommand);
	}
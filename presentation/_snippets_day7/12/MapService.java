public void createMap() throws IOException, TemplateException {
		List<CountyEntity> counties = countyDao.findAll();
		
		List<String> coordinates = new LinkedList<>();
		counties.forEach(county -> {
			StringBuffer command = new StringBuffer();
			county.getPathCommands().forEach(pathCommand -> {
				command.append(pathCommand.toString()).append(" ");
			});
			coordinates.add(command.toString());			
		});
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("coordinates", coordinates);

		templateService.create(new FileWriter("../map.svg"), "map-template.xml", data);
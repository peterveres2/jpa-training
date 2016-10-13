	public CountyEntity findByName(String name) {
		TypedQuery<CountyEntity> query = entityManager.createQuery("select c from county c where c.name = :name", CountyEntity.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}
	
	public CountyEntity findByOrigId(String origId) {
		TypedQuery<CountyEntity> query = entityManager.createQuery("select c from county c where c.origId = :origId", CountyEntity.class);
		query.setParameter("origId", origId);
		return query.getSingleResult();
	}
	
	public Integer findLargestCountySize() {
		TypedQuery<Integer> query = entityManager.createQuery("select max(c.size) from county c", Integer.class);
		return query.getSingleResult();
	}	
	
	public Statistics getStatistics() {
		TypedQuery<Statistics> query = entityManager.createQuery("select "
				+ "new com.epam.jpatraining.map.domain.Statistics(max(c.size), min(c.size), avg(c.size), max(c.population), min(c.population), avg(c.population)) "
				+ "from county c", Statistics.class);
		return query.getSingleResult();
	}
		
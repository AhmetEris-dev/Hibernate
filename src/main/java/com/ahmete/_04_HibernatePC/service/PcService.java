package com.ahmete._04_HibernatePC.service;

import com.ahmete._04_HibernatePC.entity.Pc;
import com.ahmete._04_HibernatePC.repository.PcRepository;

public class PcService extends ServiceManager<Pc, Long> {
	private final PcRepository pcRepository;
	
	
	public PcService() {
		this(new PcRepository());
	}
	
	private PcService(PcRepository pcRepository) {
		super(pcRepository);
		this.pcRepository = pcRepository;
		
	}
}
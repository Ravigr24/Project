package com.prj.dheeyantra.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.dheeyantra.exception.ResourceNotFoundException;
import com.prj.dheeyantra.model.DheeYantra;
import com.prj.dheeyantra.repo.DheeYantraRepo;
import com.prj.dheeyantra.service.DheeYantraService;

@Service
public class DheeYantraServiceImpl implements DheeYantraService{
	
	@Autowired
	DheeYantraRepo repo;

	@Override
	public DheeYantra addDheeYantra(DheeYantra dheeYantra) {
		
		DheeYantra yantra= repo.save(dheeYantra);
		int n=yantra.getId();
		int num=1;
		int i=0;
		int count=0;
		while (count < n)  
		{  
		num=num+1;  
		for (i = 2; i <= num; i++)  
		{   
		if (num % i == 0)   
		{  
		break;  
		}  
		}  
		if ( i == num)  
		{  
		count = count+1;  
		}  
		}  
		yantra.setPrimeNumber(num);
		DheeYantra yantra2=repo.save(dheeYantra);
		System.out.println("saving "+n+"th prime "+num);
		return yantra2;
	}
	
	@Override
	public List<DheeYantra> getAllDheeYantra() {
		
		return repo.findAll();
	}
	
	@Override
	public DheeYantra getDheeYantraById(int id) {
		
		DheeYantra dheeYantra= repo.findById(id).orElseThrow(()->new ResourceNotFoundException("DheeYantra","id",id));
		
		return dheeYantra;
	}

	@Override
	public void deleteDheeYantraById(int id) {
		
		repo.findById(id).orElseThrow(()->new ResourceNotFoundException("DheeYantra","id",id));
		 repo.deleteById(id);
		
	}

	

	
	
	

}

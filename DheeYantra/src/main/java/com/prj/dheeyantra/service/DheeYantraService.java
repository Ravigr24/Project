package com.prj.dheeyantra.service;

import java.util.List;

import com.prj.dheeyantra.model.DheeYantra;




public interface DheeYantraService {


	DheeYantra addDheeYantra(DheeYantra dheeYantra);
	void deleteDheeYantraById(int id);
	DheeYantra getDheeYantraById(int id);
	List<DheeYantra> getAllDheeYantra();
}

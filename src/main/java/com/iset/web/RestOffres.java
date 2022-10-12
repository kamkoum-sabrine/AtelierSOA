package com.iset.web;

import java.util.List;
import java.util.Optional;

import javax.persistence.PostUpdate;

import com.iset.dao.OffreRepository;
import com.iset.entities.Offre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Offres")
public class RestOffres {
    @Autowired
    OffreRepository offreRepository;

    @GetMapping
    public List<Offre> getAll() {
        return offreRepository.findAll();
    }

    @GetMapping("/{uid}")
    public Offre getbyid(@PathVariable Long uid) {

        return offreRepository.findById(uid).get();
    }

    @PostMapping
    public Offre saveoffre(@RequestBody Offre newoffre) {
        return offreRepository.save(newoffre);
    }

    @DeleteMapping("/{id}")
    public void deleteoffre(@PathVariable Long id) {
        offreRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<Offre> updateoffre(@RequestBody Offre newOffre, @PathVariable Long id) {
        return offreRepository.findById(id)
                .map(offre -> {
                    offre.setIntitulé(newOffre.getIntitulé());
                    offre.setPays(newOffre.getPays());
                    offre.setSociété(newOffre.getSociété());
                    offre.setSpecialité(newOffre.getSpecialité());
                    offre.setNbpostes(newOffre.getNbpostes());
                    return offreRepository.save(offre);
                });

    }

}
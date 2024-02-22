package com.review.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.review.demo.Model.DetailModel;
import com.review.demo.Service.DetailService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DetailController {
    public DetailService detailService;


    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @PostMapping("/detail")
    public DetailModel jj(@RequestBody DetailModel detailModel)
    {
        return detailService.AddDetail(detailModel);
    }
    
    @GetMapping("/detailsofdet/{id}")
    public ResponseEntity<DetailModel> getting(@PathVariable("id") int id)
    {
        DetailModel obj=detailService.indById(id);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/detail/{id}")
    public ResponseEntity<DetailModel> putMethodName(@PathVariable("id") int id, @RequestBody DetailModel detailModel) {
        if(detailService.updateDetails(id,detailModel) == true)
        {
            return new ResponseEntity<>(detailModel,HttpStatus.OK);
        }
        return new ResponseEntity<>(detailModel,HttpStatus.NOT_FOUND);
    }

      @DeleteMapping("/deletedetails/{eventId}")
    public ResponseEntity<DetailModel> deleteProperty(@PathVariable("eventId") int id)
    {
        if(detailService.deleteDetails(id) == true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

    }

}

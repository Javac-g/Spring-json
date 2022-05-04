package com.MaksDenysov.Service;

import com.MaksDenysov.Controller.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Serv {

    public List<ResponseDTO> datalist = new ArrayList<>();


    public ResponseDTO create(RequestDTO requestDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setName("Person name is: " + requestDTO.getName());
        responseDTO.setPosition("Person position is: " + requestDTO.getPosition());
        responseDTO.setId(requestDTO.getId());
        datalist.add(responseDTO);
        return responseDTO;

    }
    public ResponseDTO find(Integer id){

        for(ResponseDTO serch: datalist){
            if(serch.getId().equals(id)){
                return serch;
            }
        }

        return null;
    }

    public ResponseDTO update(RequestDTO requestDTO, Integer id){

        ResponseDTO update = find(id);
        if(update != null){
            update.setId(requestDTO.getId());
            update.setName(requestDTO.getName());
            update.setPosition(requestDTO.getPosition());
            return update;
        }
        return null;

    }
    public Integer delete(Integer id){
        int indexToRemove = -1;
        for (int i =0 ; i <= datalist.size(); i++){
            if(datalist.get(i).getId().equals(id)){
                indexToRemove = i;
                break;
            }
        }
        if(indexToRemove != -1){

            datalist.remove(indexToRemove);

        }
        return indexToRemove;

    }
}

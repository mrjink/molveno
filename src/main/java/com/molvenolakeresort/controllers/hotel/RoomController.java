package com.molvenolakeresort.controllers.hotel;

import com.molvenolakeresort.mappers.hotel.RoomMapper;
import com.molvenolakeresort.models.hotel.*;
import com.molvenolakeresort.repositories.hotel.RoomRepository;
import com.molvenolakeresort.views.hotel.RoomInformationView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/room/")
public class RoomController {


    private RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<RoomInformationView> getAll() {
        List<RoomInformationView> result = new ArrayList<>();
        for (Room room : this.roomRepository.findAll()) {
            result.add(RoomMapper.mapRoomToRoomInformationView(room));
        }
        return result;
    }
}

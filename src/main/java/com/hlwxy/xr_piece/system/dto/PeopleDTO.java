package com.hlwxy.xr_piece.system.dto;

import com.hlwxy.xr_piece.system.domain.PeopleDO;

/**
 * @author shkstart
 * @create 2019-11-13-9:33
 */
public class PeopleDTO extends PeopleDO {
    private String bmName;


    public PeopleDTO() {
    }

    public PeopleDTO(String bmName) {
        this.bmName = bmName;
    }


    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    @Override
    public String toString() {
        return "peopleDTO{" +
                "bmName='" + bmName + '\'' +
                '}';
    }
}

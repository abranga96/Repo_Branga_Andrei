package Airplane;

import UUIDManager.SeatUUID;

import java.util.UUID;

/**
 * Created by abran on 17.01.2017.
 */
public abstract class Seat implements  java.lang.Comparable<Seat>
{
    public UUID id;
    public boolean occupied;
    private SeatType seatType;
    private int seatNr;
    public void setSeatNr(int nr)
    {
        this.seatNr=nr;
    }
    public int getSeatNr()
    {
        return seatNr;
    }

    public  Seat()
    {
        this.id= SeatUUID.getID();
        this.occupied=false;
    }

    public boolean getOccupiedStatus()
    {
        return occupied;

    }

    public SeatType getSeatType()
    {
        return seatType;
    }

    public void setSeatType(SeatType seatType)
    {
        this.seatType=seatType;
    }

    public void occupy()
    {
        this.occupied=true;
    }

    public void unoccupy()
    {
        this.occupied=false;
    }
}

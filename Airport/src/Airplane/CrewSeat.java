package Airplane;

import UUIDManager.SeatUUID;
import org.jetbrains.annotations.NotNull;

/**
 * Created by abran on 17.01.2017.
 */
public class CrewSeat extends Seat
{
    public  CrewSeat(int seatNr)
    {
        super();
        setSeatType(SeatType.CREW);
        setSeatNr(seatNr);
    }


    @Override
    public int compareTo(@NotNull Seat o) {
        if(this.getSeatNr()<o.getSeatNr())
        {
            return -1;
        }
        if(this.getSeatNr()>o.getSeatNr())
        {
            return 1;
        }
        return  0;
    }
}

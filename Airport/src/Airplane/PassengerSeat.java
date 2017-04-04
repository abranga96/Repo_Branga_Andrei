package Airplane;

import UUIDManager.SeatUUID;
import org.jetbrains.annotations.NotNull;

/**
 * Created by abran on 17.01.2017.
 */
public class PassengerSeat extends Seat
{
    public  PassengerSeat(int seatNr)
    {
        super();
        setSeatType(SeatType.PASSENGER);
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

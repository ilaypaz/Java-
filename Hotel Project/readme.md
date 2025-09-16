The hotel tracks the current reservations for your hotel for the month of December only. So, it only maintains reservations for the 1st through 31st of December of the one room.
It contains the following methods.
• boolean requestReservation(String user, int firstDay, int lastDay)
o Attempt to make a reservation from the firstDay to the lastDay (inclusive) for the person specified by name
o Restrictions: a reservation will not be made if…
 The user already has a reservation
 If the values for firstDay or lastDay are invalid in any way.
 any of the requested days are available
o Return true if the reservation was made, false if it was not
• boolean cancelReservation(String user)
o If the specified person has a reservation, it will be cancelled (all of their days become available) and returns true
o Otherwise, returns false if they did not have a reservation to cancel
• String reservationInformation()
Returns a string containing the full reservation information for the month. For each day displays either available or the name of the person who has the reservation for that day

# Java-GUI-Music-Player

A Java GUI app where I implemented the pause and play functionalities for a music player.
Note that not all of the media files are uploaded due to large size, but all the implementation code is present.

Implementation Summary:
- Created an AudioManager class which extends the Thread class in order to make use of the run() function, which continously runs the app.
- Kept track of the general time using System.currentTimeMillis() function. 
- If the time is equal to the total time of the current song the next song is played.
- If the song is paused have a variable to save the time when the song is paused, so that once the user unpauses the song plays at the exact time when the user paused the song.

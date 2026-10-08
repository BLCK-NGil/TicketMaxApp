package app.configuration;

import app.repository.ArtistRepositoryImplCollection;
import app.repository.EventRepositoryImplCollection;
import app.repository.PlaceRepositoryImplCollection;
import app.repository.SeatRepositoryAdapter;
import app.repository.UserRepositoryImplCollection;
import app.service.ArtistServiceImpl;
import app.service.EventServiceImpl;
import app.service.PlaceServiceImpl;
import app.service.SeatServiceAdapter;
import app.service.UserServiceImpl;
import app.service.inputports.ArtistService;
import app.service.inputports.EventService;
import app.service.inputports.PlaceService;
import app.service.inputports.SeatServiceInterface;
import app.service.inputports.UserService;
import app.service.outputports.ArtistRepository;
import app.service.outputports.EventRepository;
import app.service.outputports.PlaceRepository;
import app.service.outputports.SeatRepositoryPort;
import app.service.outputports.UserRepository;
import app.ui.CliUserInterface;
import app.view.ArtistView;
import app.view.EventView;
import app.view.PlaceView;
import app.view.SeatView;
import app.view.UserView;

public class Config {

    public static CliUserInterface getCliUserInterface() {

        UserRepository userRepository = new UserRepositoryImplCollection();
        UserService userService = new UserServiceImpl(userRepository);
        UserView userView = new UserView(userService);

        SeatRepositoryPort seatRepositoryPort = new SeatRepositoryAdapter();
        SeatServiceInterface seatServiceInterface = new SeatServiceAdapter(seatRepositoryPort);
        SeatView seatView = new SeatView(seatServiceInterface);

        PlaceRepository placeRepository = new PlaceRepositoryImplCollection();
        PlaceService placeService = new PlaceServiceImpl(placeRepository);
        PlaceView placeView = new PlaceView(placeService);

        ArtistRepository artistRepository = new ArtistRepositoryImplCollection();
        ArtistService artistService = new ArtistServiceImpl(artistRepository);
        ArtistView artistView = new ArtistView(artistService);

        //recibe también placeService y artistService)
        EventRepository eventRepository = new EventRepositoryImplCollection();
        EventService eventService = new EventServiceImpl(eventRepository, placeService, artistService);
        EventView eventView = new EventView(eventService);

        return new CliUserInterface(userView, seatView, placeView, artistView, eventView);
    }

}

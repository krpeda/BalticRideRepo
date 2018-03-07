import { Ride } from './ride';

export class App {


  configureRouter(config, router) {
    config.title = 'BalticRide';
    config.map([
      {route: '', name: 'rides', moduleId: 'rides', title: 'Find Ride'},
      {route: 'ride', name: 'ride', moduleId: 'ride', title: 'Recent Rides'},
      {route: 'destination', name: 'dest', moduleId: 'dest', title: 'Add Ride'},
      {route: 'rides', name: 'rides', moduleId: 'rides', title: 'Find Ride'},
      {route: 'about', name:'about', moduleId:'about', title:'About Us'},
      {route:'allrides', name:'all', moduleId:'all', title:'All Rides'}


    ]);
  }
}

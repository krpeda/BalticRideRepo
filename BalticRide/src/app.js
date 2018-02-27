import { Ride } from './ride';

export class App {
  constructor(start, dest, time, seats, fee) {
    this.start = start;
    this.dest = dest;
    this.time = time;
    this.seats = seats;
    this.fee = fee;
    this.rideList = [];
    this.ride = '';
  }
  addRide() {
    if (this.start && this.dest && this.time) {
      this.rideList.push(new Ride(this.start, this.dest, this.time, this.seats, this.fee));
      this.start = '';
      this.dest = '';
      this.time = '';
      this.seats = '';
      this.fee = '';
    }
  }
  configureRouter(config, router) {
    config.title = 'BalticRide';
    config.map([
      {route: '', name: 'rides', moduleId: 'rides', title: 'Find Ride'},
      {route: 'ride', name: 'ride', moduleId: 'ride', title: 'Recent Rides'},
      {route: 'destination', name: 'dest', moduleId: 'dest', title: 'Add Ride'},
      {route: 'rides', name: 'rides', moduleId: 'rides', title: 'Find Ride'}

    ]);
  }
}

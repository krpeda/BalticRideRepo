import {HttpClient, json} from 'aurelia-fetch-client';
import moment from 'moment';
import App from './app';

export class All {

  rideList = []
  messageList = []
  hasJoined = 0;

  
  activate() {
    let client = new HttpClient();
    const userId = firebase.auth().currentUser.uid;
    client.fetch('http://localhost:8080/rides')
      .then(response => response.json())
      .then(rides => {
        /*this.rideList.startTime = moment.unix(this.rideList.startTime).format("yyyy-MM-dd HH:mm");*/
        this.rideList = rides; 
        for (var i = 0; i < rides.length; i++) {
            rides[i].startTime = moment(rides[i].startTime).format("DD-MM-YYYY HH:mm");
        }
      });
      client.fetch('http://localhost:8080/user/'+userId+'/messages')
        .then(response => response.json())
        .then(messages => {
            this.messageList = messages;
            console.log(this.messageList);
            this.hasJoined = this.messageList.length;
            console.log(this.hasJoined)
        })
  }

  onClickJoin(rides) {
    let index = this.rideList.indexOf(rides);
    let rideId = this.rideList[index].id;
    let start = this.rideList[index].startPoint;
    let end = this.rideList[index].endPoint;
    let car = this.rideList[index].rideCar.carModel;
    let carNr = this.rideList[index].rideCar.carRegistrationNumber;
    let startTime = this.rideList[index].startTime;
    const userId = firebase.auth().currentUser.uid;
    let saatjaId = this.rideList[index].rideCar.userId;
    let pull = `Registreerisite sõidule, mis algab linnas  ${start} ning lõppeb linnas ${end}. 
    Juht stardib kell ${startTime}.
    Juhi auto on ${car} ning numbrimärgid on ${carNr}.
     Juhul kui te ei saa sõidust osa võtta, palun vajutage Delete.`;
    console.log(userId);
    console.log(rideId);
    let client = new HttpClient();

    client.fetch('http://localhost:8080/messages/add', {
      'method':'post',
      'body':JSON.stringify({ 
        "senderId": saatjaId,
        "rideId":rideId,
        "receiverId":userId,
        "messageContent":`${pull}`,
        "sentTime":Date.now()
        })
    })
      .then(response => response.json())
      .then(messages => {
        this.messageList = messages;
      });
      console.log(this.messageList);
      location.reload();
  }
}

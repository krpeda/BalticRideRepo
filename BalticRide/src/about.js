import {HttpClient, json} from 'aurelia-fetch-client';

export class About {
  hasJoined = 0;
  activate() {
    let client = new HttpClient();
    const userId = firebase.auth().currentUser.uid;
      client.fetch('http://localhost:8080/user/'+userId+'/messages')
        .then(response => response.json())
        .then(messages => {
            this.messageList = messages;
            console.log(this.messageList);
            this.hasJoined = this.messageList.length;
            console.log(this.hasJoined)
        })
  }
}

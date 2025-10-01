import { Component, OnInit } from '@angular/core';
import {IonButtons, IonHeader, IonIcon, IonTitle, IonToolbar} from "@ionic/angular/standalone";
import {addIcons} from "ionicons";
import {bulb, checkmarkDone, heartCircleOutline} from "ionicons/icons";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
  imports: [
    IonHeader,
    IonTitle,
    IonToolbar,
    IonButtons,
    IonIcon
  ]
})
export class HeaderComponent  implements OnInit {

  constructor() {
    addIcons({bulb, checkmarkDone})
  }

  ngOnInit() {}

}

import { Component, OnInit } from '@angular/core';
import {IonButtons, IonHeader, IonIcon, IonTitle, IonToolbar} from "@ionic/angular/standalone";

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

  constructor() { }

  ngOnInit() {}

}

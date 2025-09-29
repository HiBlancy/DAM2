import { Component, OnInit } from '@angular/core';
import {
  IonButton,
  IonContent,
  IonHeader,
  IonMenu,
  IonMenuToggle,
  IonTitle,
  IonToolbar
} from "@ionic/angular/standalone";

@Component({
    selector: 'app-menu',
    templateUrl: './menu.component.html',
    styleUrls: ['./menu.component.scss'],
  imports: [
    IonButton,
    IonContent,
    IonHeader,
    IonMenu,
    IonTitle,
    IonToolbar,
    IonMenuToggle
  ]
})
export class MenuComponent  implements OnInit {

  constructor() {}

  ngOnInit() {}

}

import { Component } from '@angular/core';
import { IonApp, IonRouterOutlet } from '@ionic/angular/standalone';
import {addIcons} from "ionicons";
import {bulb, checkbox, checkmarkDone, heartCircleOutline} from "ionicons/icons";
import {MenuComponent} from "./components/menu/menu.component";

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  imports: [IonApp, IonRouterOutlet, MenuComponent],
})
export class AppComponent {
  constructor() {
    addIcons({bulb, checkmarkDone, heartCircleOutline})
  }
}

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
  IonButton, IonCol,
  IonContent,
  IonGrid,
  IonMenuButton,
  IonRow,
  IonTitle,
} from '@ionic/angular/standalone';
import {HeaderComponent} from "../../components/header/header.component";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-extra',
  templateUrl: './extra.page.html',
  styleUrls: ['./extra.page.scss'],
  standalone: true,
  imports: [IonContent, IonTitle, CommonModule, FormsModule, HeaderComponent, IonButton, IonGrid, IonRow, IonCol, RouterLink, IonMenuButton]
})
export class ExtraPage{
  constructor() {}
}

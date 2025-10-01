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
import {MenuComponent} from "../../components/menu/menu.component";

@Component({
  selector: 'app-extra',
  templateUrl: './extra.page.html',
  styleUrls: ['./extra.page.scss'],
  standalone: true,
  imports: [IonContent, IonTitle, CommonModule, FormsModule, HeaderComponent, IonButton, IonGrid, IonRow, IonCol, RouterLink, IonMenuButton, MenuComponent]
})
export class ExtraPage{
  constructor() {}
}

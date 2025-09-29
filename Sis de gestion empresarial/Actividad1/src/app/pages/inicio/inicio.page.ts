import {Component, inject, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
  IonButton,
  IonCol,
  IonContent,
  IonGrid,
  IonHeader,
  IonIcon,
  IonItem,
  IonLabel, IonRow,
  IonTitle,
  IonToolbar
} from '@ionic/angular/standalone';
import {HeaderComponent} from "../../components/header/header.component";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.page.html',
  styleUrls: ['./inicio.page.scss'],
  standalone: true,
  imports: [IonContent, IonTitle, CommonModule, FormsModule, HeaderComponent, RouterLink, IonIcon, IonGrid, IonRow, IonCol, IonButton]
})
export class InicioPage implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }
}

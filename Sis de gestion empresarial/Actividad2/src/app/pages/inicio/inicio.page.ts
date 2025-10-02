import {Component, inject, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormGroup, FormsModule} from '@angular/forms';
import {
  IonAlert,
  IonAvatar, IonButton, IonCol,
  IonContent,
  IonHeader, IonImg,
  IonItem,
  IonLabel,
  IonList,
  IonListHeader, IonRow,
  IonTitle,
  IonToolbar
} from '@ionic/angular/standalone';
import {DataService} from "../../services/data-service";
import {Inicio} from "../../common/interface";
import {Router, RouterLink} from "@angular/router";
import {AlertButton} from "@ionic/angular";

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.page.html',
  styleUrls: ['./inicio.page.scss'],
  standalone: true,
  imports: [IonContent, IonHeader, IonTitle, IonToolbar, CommonModule, FormsModule, IonList, IonItem, IonLabel, IonListHeader, IonAvatar, IonButton, RouterLink, IonCol, IonRow, IonImg, IonAlert]
})
export class InicioPage implements OnInit {
  private dataService: DataService = inject(DataService);
  private router = inject(Router);

  inicio: Inicio[] = [];

  botonesAlert: AlertButton[] = [
    {
      text: 'CANCEL',
      role: 'cancel',
      handler: () => {
        console.log('Cancel event');
      }
    },
    {
      text: 'OK',
      handler: () => {
        console.log('Accept event');
        this.router.navigate(['/sheet']);
        return true;
      }
    }
  ];

  constructor() {
  }

  ngOnInit() {
    this.cargarComponentes();
  }

  private cargarComponentes() {
    this.dataService.getComponentesInicio().subscribe({
        next: (data: Inicio[]) => {
          this.inicio = data;
        },
        error: (err: Error) => console.error(err),
      complete:   () => {
        console.log('Data loaded.')}
      }
    );
  }
}

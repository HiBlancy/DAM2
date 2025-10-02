import {ChangeDetectorRef, Component, inject, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
  IonActionSheet,
  IonAlert,
  IonAvatar,
  IonButton, IonChip, IonCol,
  IonContent, IonGrid,
  IonHeader,
  IonIcon, IonImg, IonLabel, IonRow,
  IonTitle,
  IonToolbar
} from '@ionic/angular/standalone';
import {Inicio} from "../../common/interface";
import {DataService} from "../../services/data-service";
import {addIcons} from "ionicons";
import {arrowBackOutline} from "ionicons/icons";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-sheet',
  templateUrl: './sheet.page.html',
  styleUrls: ['./sheet.page.scss'],
  standalone: true,
  imports: [IonContent, IonHeader, IonTitle, IonToolbar, CommonModule, FormsModule, IonAvatar, IonButton, IonIcon, RouterLink, IonLabel, IonChip, IonCol, IonImg, IonRow, IonGrid, IonActionSheet]
})
export class SheetPage implements OnInit {
  private dataService: DataService = inject(DataService);
  private cdRef = inject(ChangeDetectorRef); //Para que aplique los cambios al momento

  inicio: Inicio[] = [];

  currentAvatar: string = 'assets/photos/avatar01.png';
  avatarChangeAlert = [
    {
      text: 'Amon',
      handler: () => {
        this.updateAvatar('assets/photos/avatar01.png');
      }
    },
    {
      text: 'Yushu',
      handler: () => {
        this.updateAvatar('assets/photos/avatar02.png');
      }
    },
    {
      text: 'Shana',
      handler: () => {
        this.updateAvatar('assets/photos/avatar03.png');
      }
    },
    {
      text: 'Cancel',
      role: 'cancel'
    }
  ];

  constructor() {
    addIcons({arrowBackOutline})
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

  private updateAvatar(newAvatar: string) {
    this.currentAvatar = newAvatar;
    this.cdRef.detectChanges();
  }
}

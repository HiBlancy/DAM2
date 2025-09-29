import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonContent, IonHeader, IonTitle, IonToolbar } from '@ionic/angular/standalone';

@Component({
  selector: 'app-grid-buttons',
  templateUrl: './grid-buttons.page.html',
  styleUrls: ['./grid-buttons.page.scss'],
  standalone: true,
  imports: [IonContent, IonHeader, IonTitle, IonToolbar, CommonModule, FormsModule]
})
export class GridButtonsPage implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}

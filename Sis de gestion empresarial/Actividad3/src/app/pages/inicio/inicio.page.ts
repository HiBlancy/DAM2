import {Component, CUSTOM_ELEMENTS_SCHEMA, inject, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
  IonBadge,
  IonCard, IonCardContent,
  IonCardHeader, IonCardSubtitle,
  IonCardTitle,
  IonContent, IonFab, IonFabButton,
  IonHeader, IonIcon, IonImg, IonItem, IonLabel,
  IonTitle,
  IonToolbar
} from '@ionic/angular/standalone';
import {addIcons} from "ionicons";
import {alarmOutline, colorWandOutline} from "ionicons/icons";
import {ProductService, Product} from "../../services/product";
import index from "eslint-plugin-jsdoc";

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.page.html',
  styleUrls: ['./inicio.page.scss'],
  standalone: true,
  schemas:[CUSTOM_ELEMENTS_SCHEMA],
  imports: [IonContent, IonHeader, IonTitle, IonToolbar, CommonModule, FormsModule, IonCard, IonCardHeader, IonCardTitle, IonCardSubtitle, IonCardContent, IonItem, IonIcon, IonLabel, IonFab, IonFabButton, IonBadge, IonImg]
})
export class InicioPage implements OnInit {
  private productService = inject(ProductService);

  products: Product[] = [];
  pageTitle: string = "Ejercicio 03";

  constructor() {
    addIcons({alarmOutline, colorWandOutline})
  }

  ngOnInit() {
    this.loadProducts();
  }

  loadProducts() {
    this.productService.getProducts().subscribe({
      next: data => {
        this.products = data;
      },
      error: error => {
        console.error('Error al cargar los productos: ', error);
      }
    });
  }

  changeRandomTitle(){
    if (this.products.length > 0){
      const randomIndex = Math.floor(Math.random() * this.products.length);
      this.pageTitle = this.products[randomIndex].title;
    }
  }
}

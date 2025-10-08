import {Component, inject, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
  IonCard, IonCardContent,
  IonCardHeader, IonCardSubtitle,
  IonCardTitle,
  IonContent, IonFab, IonFabButton,
  IonHeader, IonIcon, IonItem, IonLabel,
  IonTitle,
  IonToolbar
} from '@ionic/angular/standalone';
import {addIcons} from "ionicons";
import {alarmOutline, colorWandOutline} from "ionicons/icons";
import {ProducService, Product} from "../../services/product";
import index from "eslint-plugin-jsdoc";

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.page.html',
  styleUrls: ['./inicio.page.scss'],
  standalone: true,
  imports: [IonContent, IonHeader, IonTitle, IonToolbar, CommonModule, FormsModule, IonCard, IonCardHeader, IonCardTitle, IonCardSubtitle, IonCardContent, IonItem, IonIcon, IonLabel, IonFab, IonFabButton]
})
export class InicioPage implements OnInit {
  private productService = inject(ProducService);

  products: Product[] = [];
  activeSlides: { [key: number] : boolean } = {};
  pageTitle: string = "Actividad 3";

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
        this.products.forEach((_, index) => {
          this.activeSlides[index] = true;
        });
      },
      error: error => {
        console.error('Error al cargar los productos: ', error);
      }
    });
  }

  toggleSlide(index: number) {
    this.activeSlides[index] = !this.activeSlides[index];
  }

  changeRandomTitle(){
    if (this.products.length > 0){
      const randomIndex = Math.floor(Math.random() * this.products.length);
      this.pageTitle = this.products[randomIndex].title;
    }
  }
}

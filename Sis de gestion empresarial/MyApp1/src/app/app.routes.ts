import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'home',
    loadComponent: () => import('./home/home.page').then((m) => m.HomePage),
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full',
  },
  {
    path: 'inicio',
    loadComponent: () => import('./pages/inicio/inicio.page').then( m => m.InicioPage)
  },
  {
    path: 'grid-buttons',
    loadComponent: () => import('./pages/grid-buttons/grid-buttons.page').then( m => m.GridButtonsPage)
  },
  {
    path: 'alert',
    loadComponent: () => import('./pages/alert/alert.page').then( m => m.AlertPage)
  },
  {
    path: 'action-sheet',
    loadComponent: () => import('./pages/action-sheet/action-sheet.page').then( m => m.ActionSheetPage)
  },
  {
    path: 'avatar',
    loadComponent: () => import('./pages/avatar/avatar.page').then( m => m.AvatarPage)
  },
];

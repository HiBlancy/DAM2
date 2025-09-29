import { ComponentFixture, TestBed } from '@angular/core/testing';
import { GridButtonsPage } from './grid-buttons.page';

describe('GridButtonsPage', () => {
  let component: GridButtonsPage;
  let fixture: ComponentFixture<GridButtonsPage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(GridButtonsPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

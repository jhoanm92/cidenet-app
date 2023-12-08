import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LazybuttonComponent } from './lazybutton.component';

describe('LazybuttonComponent', () => {
  let component: LazybuttonComponent;
  let fixture: ComponentFixture<LazybuttonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LazybuttonComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LazybuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

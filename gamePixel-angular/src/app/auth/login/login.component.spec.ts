import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { of } from 'rxjs';
import { AuthService } from '../service/auth.service';
import { LoginComponent } from './login.component';
import { LoginRequestPayload } from './login-request.payload';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

describe('Testing autenthication service',() =>{
  const authServiceStub: jasmine.SpyObj<AuthService> = jasmine.createSpyObj('authService',['login']);
  let fixture: ComponentFixture<LoginComponent>;
  let component: LoginComponent;
  beforeEach(async () => {
    fixture= TestBed.createComponent(LoginComponent);
    component= fixture.componentInstance;
    fixture.detectChanges();
    TestBed.configureTestingModule({
      declarations: [LoginComponent],
      imports: [ReactiveFormsModule],
      providers: [{
        provide: AuthService,
        useValue: authServiceStub
      }]
    }).compileComponents();

  });

  it('should invoke auth service when form is valid', () => {
    const uname = component.loginForm.controls.username;
    uname.setValue('testusername');
    const passwrd = component.loginForm.controls.password;
    passwrd.setValue('12345');
    authServiceStub.login.and.returnValue(of());
    fixture.nativeElement.querySelector('button').click();

    expect(authServiceStub.login.calls.any()).toBeTruthy(); // make sure that it's calling the AuthService class
    const payload: LoginRequestPayload = {username: uname.value, password: passwrd.value};

    expect(authServiceStub.login).toHaveBeenCalledWith(payload); // expect to have called the service class with email, password values
  });
})

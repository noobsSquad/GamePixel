import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { HeaderComponent } from './header/header.component';
import { SignupComponent } from './auth/signup/signup.component';
import { AppRoutingModule } from './app-routing.module';
<<<<<<< HEAD
=======
import { PasswordResetComponent } from './auth/password-reset/password-reset.component';
import { HttpClientModule } from '@angular/common/http';
import { NgxWebstorageModule } from 'ngx-webstorage';
>>>>>>> 3f00a3b54bbbb08a72a2bdc2af456c1f70db5453

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    SignupComponent,
    PasswordResetComponent
  ],
  imports: [BrowserModule, 
    FormsModule, 
    ReactiveFormsModule, 
    AppRoutingModule,
    NgxWebstorageModule.forRoot(),
    HttpClientModule
  ],
<<<<<<< HEAD
  imports: [BrowserModule, FormsModule, ReactiveFormsModule, AppRoutingModule],
=======
>>>>>>> 3f00a3b54bbbb08a72a2bdc2af456c1f70db5453
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

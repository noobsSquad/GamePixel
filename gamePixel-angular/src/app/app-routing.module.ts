import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { PasswordResetComponent } from './auth/password-reset/password-reset.component';


const routes: Routes =[
  {path: 'login',component:LoginComponent},
  {path: 'signup',component:SignupComponent},
  {path: 'forgotpassword', component:PasswordResetComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

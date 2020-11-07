import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
<<<<<<< HEAD
import { Router, RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './auth/signup/signup.component';
import { LoginComponent} from './auth/login/login.component';


const routes: Routes = [
  {path: '', redirectTo:'signup', pathMatch:'full'},
  {path: 'signup', component: SignupComponent},
  {path: 'login', component:LoginComponent}
  
]


@NgModule({
  declarations: [],
=======
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
>>>>>>> 3f00a3b54bbbb08a72a2bdc2af456c1f70db5453
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

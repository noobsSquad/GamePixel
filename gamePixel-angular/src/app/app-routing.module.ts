import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
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
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-password-reset',
  templateUrl: './password-reset.component.html',
  styleUrls: ['./password-reset.component.css']
})
export class PasswordResetComponent implements OnInit {

  resetForm: FormGroup;
  email: string;

  constructor() { 
    email:'';
  }

  ngOnInit(): void {
    this.resetForm= new FormGroup({
      email: new FormControl('',[Validators.required,Validators.email])
    });
  }

  reset(){
    this.email = this.resetForm.get('email').value;
    console.log(this.email);
  }

}

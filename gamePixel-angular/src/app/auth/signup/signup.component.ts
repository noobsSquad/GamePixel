import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  PASSWORD_MAX_LENGTH = 8;

  userAccount: FormGroup;

  user = {
    firstName: '',
    lastName: '',
    email: '',
    userName: '',
    password1: '',
    password2: '',
  };

  submit = false;

  /*setup form model for user account */
  configForm(): void {
    this.userAccount = new FormGroup({ 
      firstName: new FormControl(this.user.firstName, [Validators.required]),
      lastName: new FormControl(this.user.lastName, [Validators.required]),
      email: new FormControl(this.user.email, [Validators.required]),
      userName: new FormControl(this.user.userName, [Validators.required]),
      password1: new FormControl(this.user.password1, [Validators.required]),
      password2: new FormControl(this.user.password2, [Validators.required]),
    });
  }

  onCreateAccount(): void {
    this.submit = true;
  }

  ngOnInit() {}
}

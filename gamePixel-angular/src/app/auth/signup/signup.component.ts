import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { throwError } from 'rxjs';
import { AuthService } from '../service/auth.service';
import { SignUpRequestPayload } from './signup-request.payload';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  PASSWORD_MAX_LENGTH = 8;

  signupForm: FormGroup;
  signUpPayload: SignUpRequestPayload;
  flag: boolean;
  message: string;

  constructor(private authService: AuthService, private router:Router,
    private activatedRoute: ActivatedRoute){
    this.signUpPayload = {
      firstName: '',
      lastName: '',
      email: '',
      username: '',
      password: ''
    }
  };

  ngOnInit() {
    this.signupForm = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      username: new FormControl('', Validators.required),
      password: new FormControl('',Validators.required)
    });
  }

  signup() {
    this.signUpPayload.firstName = this.signupForm.get('firstName').value;
    this.signUpPayload.lastName = this.signupForm.get('lastName').value;
    this.signUpPayload.email = this.signupForm.get('email').value;
    this.signUpPayload.username = this.signupForm.get('username').value;
    this.signUpPayload.password = this.signupForm.get('password').value;
    
    this.authService.signup(this.signUpPayload)
        .subscribe(data => {
          this.flag = false;
          this.router.navigateByUrl('');
          this.message = "Sign Up Successful";
        }, error => {
          this.flag = true;
          throwError(error);
        }); 
  }
}

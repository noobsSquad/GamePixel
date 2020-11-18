import { EventEmitter, Injectable, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { LoginRequestPayload } from '../login/login-request.payload';
import { LoginResponse } from '../login/login-response.payload';
import { LocalStorageService } from 'ngx-webstorage';
import { map, tap} from 'rxjs/operators';
import { SignUpRequestPayload } from '../signup/signup-request.payload';
import { SignUpResponse } from '../signup/signup-response.payload';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  @Output() loggedIn: EventEmitter<boolean> = new EventEmitter();
  @Output() username: EventEmitter<string> = new EventEmitter();
  @Output() signedUp: EventEmitter<boolean> = new EventEmitter();

  constructor(private httpClient: HttpClient,
    private localStorage: LocalStorageService) { }

    //signup() function will go here
    /**
     * json returned: 
     * json{
     * authenticationToken: 'jwt';
     * username: 'username';
     * jwtTimer: 'jwtTimer';
     * }
     * authenticationToken: 
     * 
     */


  login(loginRequestPayload: LoginRequestPayload):Observable<boolean>{
    return this.httpClient.post<LoginResponse>('http://localhost:8080/api/auth/login',
    loginRequestPayload).pipe(map(data => {
      this.localStorage.store('authenticationToken', data.authenticationToken);

      this.loggedIn.emit(true); //Notifies if the user is loggedIn
      // this.username.emit(data.username); //add the HTTP RESPONSE TO INCLUDE THE USERNAME OF USER
      return true;
      }));
  }

  signup(signupRequestPayload: SignUpRequestPayload):Observable<boolean> {
    return this.httpClient.post<SignUpResponse>(
      'http://localhost:8080/api/auth/signup', 
      signupRequestPayload
      )
      .pipe(map(data => {
        // store verificationToken 
        this.localStorage.store('verificationToken', data.verificationToken);
        this.signedUp.emit(true);
        return true;
      }))
  }




}


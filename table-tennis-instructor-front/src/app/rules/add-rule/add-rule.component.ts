import { Component, OnInit } from '@angular/core';
import { RuleServiceService } from 'src/app/services/rules-service/rule-service.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-add-rule',
  templateUrl: './add-rule.component.html',
  styleUrls: ['./add-rule.component.scss']
})
export class AddRuleComponent implements OnInit {

  file: File;

  constructor(private ruleService: RuleServiceService) { }

  ngOnInit() {
  }


  onFileSelected(event: any) {
    this.file = event.target.files[0];
  }

  onUpload() {
    this.ruleService.addRule(this.file).subscribe(
      (data: string) => {
        console.log(data);
      }, (error: HttpErrorResponse) => {
        console.log(error.message);
      },
    );
  }

}

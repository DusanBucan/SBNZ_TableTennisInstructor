import { Component, OnInit } from '@angular/core';
import { RuleServiceService } from 'src/app/services/rules-service/rule-service.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-rule',
  templateUrl: './add-rule.component.html',
  styleUrls: ['./add-rule.component.scss']
})
export class AddRuleComponent implements OnInit {

  errorMessage = '';
  file: File;

  constructor(private ruleService: RuleServiceService,
              private toastr: ToastrService) { }

  ngOnInit() {
  }


  onFileSelected(event: any) {
    this.file = event.target.files[0];
  }

  onUpload() {
    this.ruleService.addRule(this.file).subscribe(
      (data: string[]) => {
        this.errorMessage = data.join('\n');
        if (this.errorMessage.length > 1) {
          this.toastr.error(this.errorMessage);
        } else {
          this.toastr.success('Successfully added rules');
        }
      }, (error: HttpErrorResponse) => {
        console.log(error.message);
      },
    );
  }

}

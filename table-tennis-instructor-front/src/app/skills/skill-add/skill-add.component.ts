import { Component, OnInit } from '@angular/core';
import { SkillService } from 'src/app/services/skill-service/skill.service';
import { error } from 'protractor';
import { HttpErrorResponse } from '@angular/common/http';
import { SkillEntity } from 'src/app/models/skill-model/skill.model';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SkillLevelType } from 'src/app/models/skill-model/skill-level.enum';

@Component({
  selector: 'app-skill-add',
  templateUrl: './skill-add.component.html',
  styleUrls: ['./skill-add.component.scss']
})
export class SkillAddComponent implements OnInit {

  newSkill: SkillEntity;

  skillLevels: SkillLevelType[];

  addSkillForm: FormGroup;
  nameCntr: FormControl;
  executionDescriptionCntr: FormControl;
  skillLevelCntr: FormControl;
  skillGroupCntr: FormControl;
  private submitted = false;

  constructor(private skillService: SkillService,
              private formBuilder: FormBuilder) {
    this.nameCntr = new FormControl({ value: '', disabled: false},
        [Validators.required, Validators.minLength(2)]);
    this.executionDescriptionCntr =  new FormControl({ value: '', disabled: false},
        [Validators.required, Validators.minLength(2)]);
    this.skillLevelCntr = new FormControl({ value: '', disabled: false}, [Validators.required]);
    this.skillGroupCntr = new FormControl({ value: '', disabled: false}, [Validators.required]);

    this.addSkillForm = this.formBuilder.group({
      name: this.nameCntr,
      executionDescription: this.executionDescriptionCntr,
      skillLevel : this.skillLevelCntr,
      skillGroup : this.skillGroupCntr
    });

    this.skillLevels = [];
    this.skillLevels.push(SkillLevelType.BEGINER);
    this.skillLevels.push(SkillLevelType.INTERMEDIATE);
    this.skillLevels.push(SkillLevelType.ADVANCED);


  }

  ngOnInit() {}

  onSubmit(skillForm: any) {
    this.submitted = true;

    if (skillForm.status === 'VALID') {
      this.newSkill = new SkillEntity(null,
        this.nameCntr.value, this.executionDescriptionCntr.value,
        this.skillGroupCntr.value, this.skillLevelCntr.value);

      this.skillService.add(this.newSkill).subscribe( () => {
        console.log('uspesno dodato');
      },
        (err: HttpErrorResponse) => {
          console.log(err.message);
      });
    }
  }

}

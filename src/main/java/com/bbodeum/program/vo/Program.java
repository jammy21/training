package com.bbodeum.program.vo;

import java.util.Date;
import java.util.List;

import com.bbodeum.apply.vo.Apply;
import com.bbodeum.keyword.vo.Keyword;
import com.bbodeum.trainer.vo.Trainer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Program {
   private int progId;
//   private String progTrId;
   private Trainer trainer;
//   private int progKeyId;
   private Keyword keyword;
   private String progTitle;
   private String progLocation;
   private int progPrice;
   private int progRecruitNum;
   private String progContent;
   private int progRsvStatus;
   private int progStatus;
   private Date progDue;
   private Date progStartDate;
   private Date progEndDate;
   
   private List<Apply> apply;

   @Override
   public String toString() {
      return "Program [progId=" + progId + ", trainer=" + trainer + ", keyword=" + keyword + ", progTitle="
            + progTitle + ", progLocation=" + progLocation + ", progPrice=" + progPrice + ", progRecruitNum="
            + progRecruitNum + ", progContent=" + progContent + ", progRsvStatus=" + progRsvStatus + ", progStatus="
            + progStatus + ", progDue=" + progDue + ", progStartDate=" + progStartDate + ", progEndDate="
            + progEndDate + ", apply=" + apply + "]";
   }  
}

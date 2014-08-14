/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author Oscar Montes
 */
public class EmployeeDTO {
    private String Name;
    private String Ssn;
    private int Salary;
    private int Dno;

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Ssn
     */
    public String getSsn() {
        return Ssn;
    }

    /**
     * @param Ssn the Ssn to set
     */
    public void setSsn(String Ssn) {
        this.Ssn = Ssn;
    }

    /**
     * @return the Salary
     */
    public int getSalary() {
        return Salary;
    }

    /**
     * @param Salary the Salary to set
     */
    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    /**
     * @return the Dno
     */
    public int getDno() {
        return Dno;
    }

    /**
     * @param Dno the Dno to set
     */
    public void setDno(int Dno) {
        this.Dno = Dno;
    }
}

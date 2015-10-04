/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.spring.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author DIEGO
 */
@Embeddable
public class SipreBoletaDetallePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CBC_MES_PROCESO")
    private String cbcMesProceso;
    @Basic(optional = false)
    @Column(name = "CBC_NRO_ADM")
    private String cbcNroAdm;
    @Basic(optional = false)
    @Column(name = "NBC_NUM_PROCESO")
    private short nbcNumProceso;
    @Basic(optional = false)
    @Column(name = "CBD_TIP_PLANILLA")
    private String cbdTipPlanilla;
    @Basic(optional = false)
    @Column(name = "NBD_SEC")
    private short nbdSec;

    public SipreBoletaDetallePK() {
    }

    public SipreBoletaDetallePK(String cbcMesProceso, String cbcNroAdm, short nbcNumProceso, String cbdTipPlanilla, short nbdSec) {
        this.cbcMesProceso = cbcMesProceso;
        this.cbcNroAdm = cbcNroAdm;
        this.nbcNumProceso = nbcNumProceso;
        this.cbdTipPlanilla = cbdTipPlanilla;
        this.nbdSec = nbdSec;
    }

    public String getCbcMesProceso() {
        return cbcMesProceso;
    }

    public void setCbcMesProceso(String cbcMesProceso) {
        this.cbcMesProceso = cbcMesProceso;
    }

    public String getCbcNroAdm() {
        return cbcNroAdm;
    }

    public void setCbcNroAdm(String cbcNroAdm) {
        this.cbcNroAdm = cbcNroAdm;
    }

    public short getNbcNumProceso() {
        return nbcNumProceso;
    }

    public void setNbcNumProceso(short nbcNumProceso) {
        this.nbcNumProceso = nbcNumProceso;
    }

    public String getCbdTipPlanilla() {
        return cbdTipPlanilla;
    }

    public void setCbdTipPlanilla(String cbdTipPlanilla) {
        this.cbdTipPlanilla = cbdTipPlanilla;
    }

    public short getNbdSec() {
        return nbdSec;
    }

    public void setNbdSec(short nbdSec) {
        this.nbdSec = nbdSec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cbcMesProceso != null ? cbcMesProceso.hashCode() : 0);
        hash += (cbcNroAdm != null ? cbcNroAdm.hashCode() : 0);
        hash += (int) nbcNumProceso;
        hash += (cbdTipPlanilla != null ? cbdTipPlanilla.hashCode() : 0);
        hash += (int) nbdSec;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SipreBoletaDetallePK)) {
            return false;
        }
        SipreBoletaDetallePK other = (SipreBoletaDetallePK) object;
        if ((this.cbcMesProceso == null && other.cbcMesProceso != null) || (this.cbcMesProceso != null && !this.cbcMesProceso.equals(other.cbcMesProceso))) {
            return false;
        }
        if ((this.cbcNroAdm == null && other.cbcNroAdm != null) || (this.cbcNroAdm != null && !this.cbcNroAdm.equals(other.cbcNroAdm))) {
            return false;
        }
        if (this.nbcNumProceso != other.nbcNumProceso) {
            return false;
        }
        if ((this.cbdTipPlanilla == null && other.cbdTipPlanilla != null) || (this.cbdTipPlanilla != null && !this.cbdTipPlanilla.equals(other.cbdTipPlanilla))) {
            return false;
        }
        if (this.nbdSec != other.nbdSec) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.codejava.spring.model.SipreBoletaDetallePK[ cbcMesProceso=" + cbcMesProceso + ", cbcNroAdm=" + cbcNroAdm + ", nbcNumProceso=" + nbcNumProceso + ", cbdTipPlanilla=" + cbdTipPlanilla + ", nbdSec=" + nbdSec + " ]";
    }
    
}
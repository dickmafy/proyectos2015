/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DIEGO
 */
@Entity
@Table(name = "SIPRE_BOLETA_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SipreBoletaDetalle.findAll", query = "SELECT s FROM SipreBoletaDetalle s")})
public class SipreBoletaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SipreBoletaDetallePK sipreBoletaDetallePK;
    @Column(name = "CBD_TIP_CONCPTO")
    private Character cbdTipConcpto;
    @Column(name = "CBD_COD_ING_DESC")
    private String cbdCodIngDesc;
    @Column(name = "VBD_DSC_ING_DESC")
    private String vbdDscIngDesc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NBD_MONTO")
    private BigDecimal nbdMonto;
    @Column(name = "NBD_NUM_CUO_TOTAL")
    private Short nbdNumCuoTotal;
    @Column(name = "NBD_NUM_CUO_PAGADA")
    private Short nbdNumCuoPagada;
    @Column(name = "CBD_IND_SUBTITULO")
    private Character cbdIndSubtitulo;
    @Column(name = "CBD_COD_MEF")
    private String cbdCodMef;
    @JoinColumns({
        @JoinColumn(name = "CBC_MES_PROCESO", referencedColumnName = "CBC_MES_PROCESO", insertable = false, updatable = false),
        @JoinColumn(name = "NBC_NUM_PROCESO", referencedColumnName = "NBC_NUM_PROCESO", insertable = false, updatable = false),
        @JoinColumn(name = "CBC_NRO_ADM", referencedColumnName = "CBC_NRO_ADM", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private SipreBoletaCabecera sipreBoletaCabecera;

    public SipreBoletaDetalle() {
    }

    public SipreBoletaDetalle(SipreBoletaDetallePK sipreBoletaDetallePK) {
        this.sipreBoletaDetallePK = sipreBoletaDetallePK;
    }

    public SipreBoletaDetalle(String cbcMesProceso, String cbcNroAdm, short nbcNumProceso, String cbdTipPlanilla, short nbdSec) {
        this.sipreBoletaDetallePK = new SipreBoletaDetallePK(cbcMesProceso, cbcNroAdm, nbcNumProceso, cbdTipPlanilla, nbdSec);
    }

    public SipreBoletaDetallePK getSipreBoletaDetallePK() {
        return sipreBoletaDetallePK;
    }

    public void setSipreBoletaDetallePK(SipreBoletaDetallePK sipreBoletaDetallePK) {
        this.sipreBoletaDetallePK = sipreBoletaDetallePK;
    }

    public Character getCbdTipConcpto() {
        return cbdTipConcpto;
    }

    public void setCbdTipConcpto(Character cbdTipConcpto) {
        this.cbdTipConcpto = cbdTipConcpto;
    }

    public String getCbdCodIngDesc() {
        return cbdCodIngDesc;
    }

    public void setCbdCodIngDesc(String cbdCodIngDesc) {
        this.cbdCodIngDesc = cbdCodIngDesc;
    }

    public String getVbdDscIngDesc() {
        return vbdDscIngDesc;
    }

    public void setVbdDscIngDesc(String vbdDscIngDesc) {
        this.vbdDscIngDesc = vbdDscIngDesc;
    }

    public BigDecimal getNbdMonto() {
        return nbdMonto;
    }

    public void setNbdMonto(BigDecimal nbdMonto) {
        this.nbdMonto = nbdMonto;
    }

    public Short getNbdNumCuoTotal() {
        return nbdNumCuoTotal;
    }

    public void setNbdNumCuoTotal(Short nbdNumCuoTotal) {
        this.nbdNumCuoTotal = nbdNumCuoTotal;
    }

    public Short getNbdNumCuoPagada() {
        return nbdNumCuoPagada;
    }

    public void setNbdNumCuoPagada(Short nbdNumCuoPagada) {
        this.nbdNumCuoPagada = nbdNumCuoPagada;
    }

    public Character getCbdIndSubtitulo() {
        return cbdIndSubtitulo;
    }

    public void setCbdIndSubtitulo(Character cbdIndSubtitulo) {
        this.cbdIndSubtitulo = cbdIndSubtitulo;
    }

    public String getCbdCodMef() {
        return cbdCodMef;
    }

    public void setCbdCodMef(String cbdCodMef) {
        this.cbdCodMef = cbdCodMef;
    }

    public SipreBoletaCabecera getSipreBoletaCabecera() {
        return sipreBoletaCabecera;
    }

    public void setSipreBoletaCabecera(SipreBoletaCabecera sipreBoletaCabecera) {
        this.sipreBoletaCabecera = sipreBoletaCabecera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sipreBoletaDetallePK != null ? sipreBoletaDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SipreBoletaDetalle)) {
            return false;
        }
        SipreBoletaDetalle other = (SipreBoletaDetalle) object;
        if ((this.sipreBoletaDetallePK == null && other.sipreBoletaDetallePK != null) || (this.sipreBoletaDetallePK != null && !this.sipreBoletaDetallePK.equals(other.sipreBoletaDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.codejava.spring.model.SipreBoletaDetalle[ sipreBoletaDetallePK=" + sipreBoletaDetallePK + " ]";
    }
    
}

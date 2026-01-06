# -*- coding: utf-8 -*-
# Copyright 2011 Daniel Reis
# Copyright 2016 LasLabs Inc.
# Autor Modificacion : Leonardo Silva Medina leonardo25s@hotmail.com
# License LGPL-3.0 or later (http://www.gnu.org/licenses/lgpl.html).

import logging
import os

from odoo import api
from odoo import _ , models
from odoo.exceptions import ValidationError
import platform

_logger = logging.getLogger(__name__)

try:
    from odoo.addons.base_external_dbsource.models import (
        base_external_dbsource,
    )
    CONNECTORS = base_external_dbsource.BaseExternalDbsource.CONNECTORS
    try:
        _logger.info('Enlazando Oracle libraries: trying cx_Oracle or python-oracledb.')
        try:
            import cx_Oracle
            _logger.info('Using cx_Oracle python package.')
        except ModuleNotFoundError:
            try:
                import oracledb as cx_Oracle
                _logger.info('Using python-oracledb as cx_Oracle replacement.')
            except ModuleNotFoundError:
                raise TypeError(_("Oracle libraries not available. Please install cx_Oracle or python-oracledb python package."))
        # Initialize Oracle client if supported & needed
        if hasattr(cx_Oracle, 'init_oracle_client'):
            try:
                if platform.system() == "Linux":
                    cx_Oracle.init_oracle_client(lib_dir=r'/opt/oracle/instantclient_21_11/')
                else:
                    try:
                        cx_Oracle.init_oracle_client(lib_dir=r"C:\oracle64\instantclient_19_14")
                    except Exception:
                        try:
                            cx_Oracle.init_oracle_client(lib_dir=r"C:\Users\macardenas\Downloads\instantclient_19_14")
                        except Exception:
                            cx_Oracle.init_oracle_client(lib_dir=r"C:\APPS FENALCOVALLE TI\APPS BASE DE DATOS\CLIENTES CONEXION A BDs\instantclient_19_14")
            except Exception as e:
                _logger.warning('Failed to init Oracle client: %s', e)

        CONNECTORS.append(('cx_Oracle', 'Oracle'))
except ImportError:
    _logger.info('base_external_dbsource Odoo module not found.')
    raise TypeError(_("base_external_dbsource Odoo module not found."))

 
class BaseExternalDbsource(models.Model):
    """ It provides logic for connection to an Oracle data source. """

    _inherit = "base.external.dbsource"

    PWD_STRING_CX_ORACLE = 'Password=%s;'

    #@api.multi
    def connection_close_cx_Oracle(self, connection):
        return connection.close()

    #@api.multi
    def connection_open_cx_Oracle(self):
        os.environ['NLS_LANG'] = 'AMERICAN_AMERICA.UTF8'
        _logger.info(self.conn_string_full) 
        return cx_Oracle.connect(self.conn_string_full)
 
    #@api.multi
    def execute_cx_Oracle(self, sqlquery, sqlparams, metadata):
        return self._execute_generic(sqlquery, sqlparams, metadata)

    def execute_pk(self,sqlquery, sqlparams):  
        return self._execute_pk(sqlquery, sqlparams)

    
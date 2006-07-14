// Prevayler, The Free-Software Prevalence Layer
// Copyright 2001-2006 by Klaus Wuestefeld
//
// This library is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
// FITNESS FOR A PARTICULAR PURPOSE.
//
// Prevayler is a trademark of Klaus Wuestefeld.
// See the LICENSE file for license details.

package org.prevayler.demos.demo2.business.transactions;

import org.prevayler.GenericTransaction;
import org.prevayler.PrevalenceContext;
import org.prevayler.demos.ReadWrite;
import org.prevayler.demos.demo2.business.Account;
import org.prevayler.demos.demo2.business.Bank;

import java.io.Serializable;

@ReadWrite public class AccountCreation implements GenericTransaction<Bank, Account, Account.InvalidHolder>, Serializable {

    private static final long serialVersionUID = 476105268406333743L;

    private String _holder;

    // Necessary for Skaringa XML serialization
    private AccountCreation() {
    }

    public AccountCreation(String holder) {
        _holder = holder;
    }

    public Account executeOn(PrevalenceContext<? extends Bank> prevalenceContext) throws Account.InvalidHolder {
        return prevalenceContext.prevalentSystem().createAccount(_holder, prevalenceContext);
    }

}

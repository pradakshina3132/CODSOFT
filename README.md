"use client";
import React from "react";
import { DecorativeHeader } from "./DecorativeHeader";
import { LoginForm } from "./LoginForm";
import { DecorativeFooter } from "./DecorativeFooter";

const LoginScreen: React.FC = () => {
  return (
    <main className="overflow-hidden mx-auto w-full bg-white max-w-[480px]">
      <DecorativeHeader />
      <LoginForm />
      <DecorativeFooter />
    </main>
  );
};

export default LoginScreen;
import React from "react";

export const DecorativeHeader: React.FC = () => {
  return (
    <header className="w-full">
      <div className="flex gap-5 max-md:flex-col">
        <div className="w-6/12 max-md:ml-0 max-md:w-full">
          <div className="flex flex-col grow items-start mt-28 text-3xl font-bold tracking-tight leading-none text-center text-black whitespace-nowrap">
            <div className="flex shrink-0 bg-red-600 rounded-3xl h-[74px] w-[151px]" />
            <div className="flex z-10 shrink-0 mt-0 rounded-3xl bg-rose-950 h-[74px] w-[116px]" />
            <h1 className="self-end mt-11">LOGIN</h1>
          </div>
        </div>
        <div className="ml-5 w-6/12 max-md:ml-0 max-md:w-full">
          <div className="flex flex-col">
            <div className="flex shrink-0 bg-red-600 rounded-3xl h-[74px]" />
            <div className="flex z-10 shrink-0 self-end mt-0 rounded-3xl bg-red-950 h-[74px] w-[167px]" />
          </div>
        </div>
      </div>
    </header>
  );
};
"use client";
import React, { useState } from "react";
import { InputField } from "./InputField";
import { RememberMeCheckbox } from "./RememberMeCheckbox";

export const LoginForm: React.FC = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [rememberMe, setRememberMe] = useState(false);
  const [showPassword, setShowPassword] = useState(false);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // Handle login logic here
    console.log({ email, password, rememberMe });
  };

  return (
    <form
      onSubmit={handleSubmit}
      className="flex flex-col items-start px-10 mt-32 w-full text-xl font-bold tracking-tight leading-none text-center text-white"
    >
      <InputField
        type="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        iconSrc="https://cdn.builder.io/api/v1/image/assets/TEMP/0a938790cf4704506e77719ecfda1bbbd71fc0a5653d18df12ed33b1d5ba8052?placeholderIfAbsent=true&apiKey=bd2d397bb31541518f9da939b19b8b0d"
        label="Email"
      />
<div className="flex gap-5 justify-between mt-28 w-full whitespace-nowrap max-w-[324px]">
        <div className="flex gap-1.5">
          <img
            src="https://cdn.builder.io/api/v1/image/assets/TEMP/2f40fa252e4d48919c154c2c2a818ea8af83faa84e5d750ecd5ed2c53655e82d?placeholderIfAbsent=true&apiKey=bd2d397bb31541518f9da939b19b8b0d"
            alt="Password icon"
            className="object-contain shrink-0 w-6 aspect-square"
          />
          <label htmlFor="password" className="my-auto">
            Password
          </label>
        </div>
        <button
          type="button"
          onClick={() => setShowPassword(!showPassword)}
          aria-label={showPassword ? "Hide password" : "Show password"}
        >
          <img
            src="https://cdn.builder.io/api/v1/image/assets/TEMP/712ce2c61fd13d7ac42255204239deb353fd8603bffe6720d14a32790a32d62f?placeholderIfAbsent=true&apiKey=bd2d397bb31541518f9da939b19b8b0d"
            alt="Toggle password visibility"
            className="object-contain shrink-0 w-6 aspect-square"
          />
        </button>
      </div>
<input
        id="password"
        type={showPassword ? "text" : "password"}
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        className="w-full bg-transparent border-none outline-none"
        aria-label="Password"
      />
<div className="shrink-0 mt-4 max-w-full h-px border border-white border-solid w-[341px]" />
<div className="flex gap-10 self-end mt-7 w-full text-sm leading-none max-w-[293px]">
        <RememberMeCheckbox
          checked={rememberMe}
          onChange={() => setRememberMe(!rememberMe)}
        />
        <button type="button" className="text-sm leading-none">
          Forgot password?
        </button>
      </div>
          <button
        type="submit"
        className="self-center px-16 py-4 mt-8 max-w-full text-3xl leading-none text-black whitespace-nowrap rounded-2xl bg-zinc-300 w-[290px]"
      >
        Login
      </button>
<div className="flex gap-4 self-center mt-3.5 max-w-full text-sm leading-none w-[228px]">
        <p className="grow shrink my-auto w-[145px]">Don't have an account? </p>
        <button type="button" className="text-sm leading-none">
          sign up?
        </button>
      </div>
    </form>
  );
};
import React from "react";

interface InputFieldProps {
  type: string;
  value: string;
  onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
  iconSrc: string;
  label: string;
}

export const InputField: React.FC<InputFieldProps> = ({
  type,
  value,
  onChange,
  iconSrc,
  label,
}) => {
  const id = label.toLowerCase();

  return (
    <>
      <div className="flex gap-1.5 whitespace-nowrap">
        <img
          src={iconSrc}
          alt={`${label} icon`}
          className="object-contain shrink-0 w-6 aspect-square"
        />
        <label htmlFor={id} className="my-auto">
          {label}
        </label>
      </div>
      <input
        id={id}
        type={type}
        value={value}
        onChange={onChange}
        className="w-full bg-transparent border-none outline-none"
        aria-label={label}
      />
      <div className="shrink-0 mt-3 max-w-full h-px border border-white border-solid w-[341px]" />
    </>
  );
};
"use client";
import React from "react";

interface RememberMeCheckboxProps {
  checked: boolean;
  onChange: () => void;
}

export const RememberMeCheckbox: React.FC<RememberMeCheckboxProps> = ({
  checked,
  onChange,
}) => {
  return (
    <div className="flex flex-1 gap-1.5">
      <button
        type="button"
        onClick={onChange}
        className="flex shrink-0 my-auto w-3.5 h-3.5 bg-zinc-300"
        aria-checked={checked}
        role="checkbox"
      >
        {checked && (
          <span className="flex items-center justify-center w-full h-full text-xs">
            ✓
          </span>
        )}
      </button>
      <span>Remember me</span>
    </div>
  );
};
import React from "react";

export const DecorativeFooter: React.FC = () => {
  return (
    <footer>
      <div className="flex z-10 mt-28 w-full rounded-3xl bg-red-950 min-h-[21px]" />
      <div className="flex -mt-2.5 w-full bg-red-600 rounded-3xl min-h-[26px]" />
    </footer>
  );
};
"use client";
import * as React from "react";
import DecorativeBlocks from "./DecorativeBlocks";
import FormField from "./FormField";
import PasswordField from "./PasswordField";
import FooterBlocks from "./FooterBlocks";

function IPhone14Plus2() {
  const [rememberMe, setRememberMe] = React.useState(false);

  return (
    <main className="overflow-hidden mx-auto w-full bg-white max-w-[480px]">
      <DecorativeBlocks />
<section className="flex flex-col items-start px-8 mt-9 w-full text-xl font-bold tracking-tight leading-none text-center text-white">
        <h1 className="text-3xl leading-none text-black">Create an account</h1>
<FormField
          icon="https://cdn.builder.io/api/v1/image/assets/TEMP/b915ff65b0252749eeddd734310e4c66922ee6a3ee836061b61b79c07cfc065e?placeholderIfAbsent=true&apiKey=bd2d397bb31541518f9da939b19b8b0d"
          label="Name"
          className="mt-20"
        />
<FormField
          icon="https://cdn.builder.io/api/v1/image/assets/TEMP/0a938790cf4704506e77719ecfda1bbbd71fc0a5653d18df12ed33b1d5ba8052?placeholderIfAbsent=true&apiKey=bd2d397bb31541518f9da939b19b8b0d"
          label="Email"
          className="mt-8"
        />
<PasswordField label="Password" className="mt-6" />
<PasswordField label="Confirm Password" className="mt-6" />
<div className="flex gap-10 self-end mt-7 w-full text-sm leading-none max-w-[293px]">
          <label className="flex flex-1 gap-1.5 cursor-pointer">
            <div
              className={`flex shrink-0 my-auto w-3.5 h-3.5 ${rememberMe ? "bg-zinc-500" : "bg-zinc-300"}`}
              onClick={() => setRememberMe(!rememberMe)}
              role="checkbox"
              aria-checked={rememberMe}
              tabIndex={0}
            />
            <span>Remember me</span>
          </label>
          <button className="text-sm">Forgot password?</button>
        </div>
<button className="self-center px-16 py-4 mt-8 max-w-full text-3xl leading-none text-black whitespace-nowrap rounded-2xl bg-zinc-300 w-[290px]">
          Login
        </button>
 <div className="flex gap-3 self-center mt-4 max-w-full text-sm leading-none w-[236px]">
          <p className="grow shrink w-40">Already have an account?</p>
          <button>Sign in?</button>
        </div>
      </section>
<FooterBlocks />
    </main>
  );
}

export default IPhone14Plus2;
import React from "react";

const DecorativeBlocks: React.FC = () => {
  return (
    <section className="w-full" aria-hidden="true">
      <div className="flex gap-5 max-md:flex-col">
        <div className="w-[43%] max-md:ml-0 max-md:w-full">
          <div className="flex flex-col grow items-start mt-20">
            <img
              src="https://cdn.builder.io/api/v1/image/assets/TEMP/acaab36b7cb43908114b4da5c1d048e71dae890c0c5825a2928a78cb8b0c843b?placeholderIfAbsent=true&apiKey=bd2d397bb31541518f9da939b19b8b0d"
              alt=""
              className="object-contain ml-7 w-6 aspect-[1.72]"
            />
            <div className="flex shrink-0 self-stretch mt-4 bg-red-600 rounded-3xl h-[74px]" />
            <div className="flex z-10 shrink-0 mt-0 rounded-3xl bg-rose-950 h-[74px] w-[116px]" />
          </div>
        </div>
        <div className="ml-5 w-[57%] max-md:ml-0 max-md:w-full">
          <div className="flex flex-col">
            <div className="flex shrink-0 bg-red-600 rounded-3xl h-[74px]" />
            <div className="flex z-10 shrink-0 self-end mt-0 rounded-3xl bg-red-950 h-[74px] w-[167px]" />
          </div>
        </div>
      </div>
    </section>
  );
};

export default DecorativeBlocks;
import React from "react";

interface FormFieldProps {
  icon: string;
  label: string;
  className?: string;
}

const FormField: React.FC<FormFieldProps> = ({
  icon,
  label,
  className = "",
}) => {
  return (
    <>
      <div className={`flex gap-2 whitespace-nowrap ${className}`}>
        <img
          src={icon}
          alt=""
          className="object-contain shrink-0 w-6 aspect-square"
        />
        <label className="my-auto">{label}</label>
      </div>
      <div className="shrink-0 mt-3 max-w-full h-px border border-white border-solid w-[341px]" />
    </>
  );
};

export default FormField;
"use client";
import React, { useState } from "react";

interface PasswordFieldProps {
  label: string;
  className?: string;
}

const PasswordField: React.FC<PasswordFieldProps> = ({
  label,
  className = "",
}) => {
  const [showPassword, setShowPassword] = useState(false);

  const togglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  return (
    <>
      <div
        className={`flex gap-5 justify-between items-start w-full whitespace-nowrap ${className}`}
      >
        <div className="flex gap-px">
          <img
            src="https://cdn.builder.io/api/v1/image/assets/TEMP/2f40fa252e4d48919c154c2c2a818ea8af83faa84e5d750ecd5ed2c53655e82d?placeholderIfAbsent=true&apiKey=bd2d397bb31541518f9da939b19b8b0d"
            alt=""
            className="object-contain shrink-0 w-6 aspect-square"
          />
          <label className="basis-auto">{label}</label>
        </div>
        <button
          onClick={togglePasswordVisibility}
          aria-label={showPassword ? "Hide password" : "Show password"}
        >
          <img
            src="https://cdn.builder.io/api/v1/image/assets/TEMP/712ce2c61fd13d7ac42255204239deb353fd8603bffe6720d14a32790a32d62f?placeholderIfAbsent=true&apiKey=bd2d397bb31541518f9da939b19b8b0d"
            alt=""
            className="object-contain shrink-0 w-6 aspect-square"
          />
        </button>
      </div>
      <div className="shrink-0 mt-4 max-w-full h-px border border-white border-solid w-[341px]" />
    </>
  );
};

export default PasswordField;
import React from "react";

const FooterBlocks: React.FC = () => {
  return (
    <div aria-hidden="true">
      <div className="flex z-10 mt-28 w-full rounded-3xl bg-red-950 min-h-[21px]" />
      <div className="flex -mt-2.5 w-full bg-red-600 rounded-3xl min-h-[26px]" />
    </div>
  );
};

export default FooterBlocks;



